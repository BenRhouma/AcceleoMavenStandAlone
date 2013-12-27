/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofrecom.ui;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.xml.sax.SAXException;

/**
 *
 * @author z.benrhouma
 */
public class MybatisGenXmlHandler {

    File xmlFile = null;
    final SAXReader saxReader = new SAXReader(true);
    String tableName;

    public MybatisGenXmlHandler(String tableName) {
        this.tableName = tableName;
    }

    void generateMybatisXmlConfiguration() throws UnsupportedEncodingException, IOException {
        final Document document = this.getDocument();

        this.modifyJavaClientElement(document);
        this.modifyJavaModelElement(document);
        this.modifyTableElement(document);
        this.modifyDriverPath(document);
        this.modifyJDBCElement(document);
        saveDocument(document);

    }

    private void modifyJavaClientElement(Document document) {
        final Element javaClientElement = (Element) document.getRootElement().selectSingleNode("/generatorConfiguration/context/javaClientGenerator");
        final Attribute targetpackage = javaClientElement.attribute("targetPackage");
        final Attribute targetProjectPath = javaClientElement.attribute("targetProject");
        targetProjectPath.setValue(Configuration.getProperty(Configuration.TargetProjectPathField));
        targetpackage.setValue(Configuration.getProperty(Configuration.JavaClientTargetPathField));
    }

    private void modifyDriverPath(Document document) {
        final Element javaClientElement = (Element) document.getRootElement().selectSingleNode("/generatorConfiguration/classPathEntry");
        final Attribute locationAttribute = javaClientElement.attribute("location");
        locationAttribute.setValue(Configuration.getProperty(Configuration.JDBCDriverPathField));
    }

    private void modifyJavaModelElement(Document document) {
        Element javaModelGeneratorElement = (Element) document.getRootElement().selectSingleNode("/generatorConfiguration/context/javaModelGenerator");
        final Attribute targetpackage = javaModelGeneratorElement.attribute("targetPackage");
        final Attribute targetProjectPath = javaModelGeneratorElement.attribute("targetProject");
        targetProjectPath.setValue(Configuration.getProperty(Configuration.TargetProjectPathField));
        targetpackage.setValue(Configuration.getProperty(Configuration.JavaModelTargetPathField));
    }

    private void modifyJDBCElement(Document document) {
        Element javaModelGeneratorElement = (Element) document.getRootElement().selectSingleNode("/generatorConfiguration/context/jdbcConnection");
        final Attribute driverClass = javaModelGeneratorElement.attribute("driverClass");
        final Attribute connectionURL = javaModelGeneratorElement.attribute("connectionURL");
        final Attribute userId = javaModelGeneratorElement.attribute("userId");
        final Attribute password = javaModelGeneratorElement.attribute("password");
        driverClass.setValue(Configuration.getProperty(Configuration.JdbcDriver));
        connectionURL.setValue(Configuration.getProperty(Configuration.DataBaseCnxUrl));
        userId.setValue(Configuration.getProperty(Configuration.DBUser));
        password.setValue(Configuration.getProperty(Configuration.DBPassword));

    }

    private void modifyTableElement(Document document) {
        Element tableElement = (Element) document.getRootElement().selectSingleNode("/generatorConfiguration/context/table");
        final Attribute tableNameAttribute = tableElement.attribute("tableName");
        tableNameAttribute.setValue(tableName);

    }

    public void saveDocument(Document document) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        try (FileOutputStream fos = new FileOutputStream(Configuration.XMLTemplate)) {
            OutputFormat format = OutputFormat.createPrettyPrint();
            // Create the xml writer by passing outputstream and format
            XMLWriter writer = new XMLWriter(fos, format);
            // Write to the xml document
            writer.write(document);
            // Flush after done
            writer.flush();
            writer.close();
        }
    }

    static class Logger {

        public static void error(String str, Throwable e) {
            java.util.logging.Logger.getLogger(MybatisGenXmlHandler.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public Document getDocument() {
        Document document = null;
        try {
            xmlFile = new File(Configuration.XMLTemplate);
            saxReader.setValidation(false);
            saxReader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            saxReader.read(xmlFile);
            document = saxReader.read(xmlFile);
        } catch (DocumentException | SAXException ex) {
            Logger.error("parse error : XmlTvCoreParser:parse ", ex);
        }
        return document;
    }

}
