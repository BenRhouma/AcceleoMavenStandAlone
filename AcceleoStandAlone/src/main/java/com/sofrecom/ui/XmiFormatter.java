package com.sofrecom.ui;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import codegen.Attribute;
import codegen.CodegenFactory;
import codegen.Entity;
import codegen.ViewModel;

public class XmiFormatter {

    private static ClassLoader cl;
    private String[] entityNames;
    private String baseDtoPath;
    private String classesPath;
    private Map<String, Map<String, String>> fieldsFromDto = new HashMap<>();

    public XmiFormatter(final String entitynames[], final String packageName, final String classesPath) {
        this.baseDtoPath = packageName;
        this.entityNames = entitynames;
        this.classesPath = classesPath;
        loadFieldsForEveryEnity();

    }

    private void loadFieldsForEveryEnity() {
        for (String entity : entityNames) {
            final Map<String, String> dtoFields = getFieldsFromDto(this.classesPath, String.format("%s.%s", baseDtoPath, entity));
            fieldsFromDto.put(entity, dtoFields);
        }
    }

    /**
     * Load class from compilation directory and detect all fields and their
     * respective types
     *
     * @param classesPath : root path of the class directory
     * @param fullQualifiedClassName : the name of the class proceeded with the
     * the package name
     * @return : a map containing the field name as key and the type as the
     * value
     */
    public Map<String, String> getFieldsFromDto(final String classesPath, final String fullQualifiedClassName) {
        final Map<String, String> fieldsMap = new HashMap<>();
        String path = "file:\\";

        if (!classesPath.endsWith("\\")) {
            path += classesPath + "\\";
        } else {
            path += classesPath;
        }

        try {
            URL[] urlx = {new URL(path)};
            cl = new URLClassLoader(urlx);
            Class<?> cls = cl.loadClass(fullQualifiedClassName);
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field f : declaredFields) {
                fieldsMap.put(f.getName(), f.getType().toString());
            }
            return fieldsMap;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     *
     * @return an instance of viewModel
     */
    private ViewModel buildViewModel() {

        final ViewModel viewModel = CodegenFactory.eINSTANCE.createViewModel();
        for (String entityName : entityNames) {
            viewModel.getEntities().add(this.buildEntity(entityName));
        }
        return viewModel;
    }

    private String extractClassName(String entityName) {

        return entityName;
    }

    /**
     * build an entity emf ecore instance
     *
     * @return
     */
    private Entity buildEntity(String entityName) {
        final Entity entity = CodegenFactory.eINSTANCE.createEntity();
        entity.setName(entityName);
        // add attibutes to the entity
        for (String key : fieldsFromDto.get(entityName).keySet()) {
            Attribute attribute = CodegenFactory.eINSTANCE.createAttribute();
            attribute.setName(key);
            attribute.setType(fieldsFromDto.get(entityName).get(key));
            entity.getAttributes().add(attribute);
        }
        return entity;
    }

    /**
     * register an xmi resource factory to save a file with xmi extension
     * outside Eclipse without having null pointer exception
     */
    private void registerXmiFileExtension() {
        final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        final Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("xmi", new XMIResourceFactoryImpl());
    }

    /**
     * create the file having "xmi" as extension the value entityname as name
     */
    private File createResourceFileIfNotExists() {
        // create a resource
        final File file = new File(String.format("./model/%s.xmi", entityNames[0]));
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        return file;

    }

    /**
     * build and save the xmi file from a model charged from the parsing result
     * of a POJO (DTO almost in all cases) for the parsing process we use the
     * classes directory and the name of the entity.
     */
    public void buildAndSaveViewModel() {
        registerXmiFileExtension();
        final File file = createResourceFileIfNotExists();
        final File eclipseFile = createEclipseResourceFileIfNotExists();
        final ViewModel modelToSave = buildViewModel();
        this.saveModel(modelToSave, file);
        this.saveModel(modelToSave, eclipseFile);

    }

    private void saveModel(ViewModel modelToSave, File file) {
        final ResourceSet resSet = new ResourceSetImpl();
        final Resource resource = resSet.createResource(URI.createURI("file:/"
                + file.getAbsolutePath()));

        resource.getContents().add(modelToSave);

        Map<String, Object> options = new HashMap<String, Object>();
        options.put(XMLResource.OPTION_SCHEMA_LOCATION, true);

        try {
            resource.save(options);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//	public static void main(String... args) {
//		new XmiFormatter(new String[]{"Person"}, "dto", "E:\\DevSrc\\Remot\\target\\scala-2.10\\classes").buildAndSaveViewModel();;
//	}
    private File createEclipseResourceFileIfNotExists() {
        // create a resource
        final File file = new File(String.format("%s/%s.xmi",ViewModelBuilder.eclipseModelDirectory, entityNames[0]));
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        return file;
    }
}
