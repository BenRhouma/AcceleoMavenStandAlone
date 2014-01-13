/**
 */
package codegen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link codegen.Entity#getName <em>Name</em>}</li>
 *   <li>{@link codegen.Entity#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link codegen.Entity#getContext <em>Context</em>}</li>
 *   <li>{@link codegen.Entity#getRefEntity <em>Ref Entity</em>}</li>
 *   <li>{@link codegen.Entity#getSourceColumn <em>Source Column</em>}</li>
 *   <li>{@link codegen.Entity#getDestination <em>Destination</em>}</li>
 * </ul>
 * </p>
 *
 * @see codegen.CodegenPackage#getEntity()
 * @model
 * @generated
 */
public interface Entity extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see codegen.CodegenPackage#getEntity_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link codegen.Entity#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link codegen.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see codegen.CodegenPackage#getEntity_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Context</b></em>' containment reference list.
	 * The list contents are of type {@link codegen.Context}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' containment reference list.
	 * @see codegen.CodegenPackage#getEntity_Context()
	 * @model containment="true"
	 * @generated
	 */
	EList<Context> getContext();

	/**
	 * Returns the value of the '<em><b>Ref Entity</b></em>' reference list.
	 * The list contents are of type {@link codegen.Entity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Entity</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Entity</em>' reference list.
	 * @see codegen.CodegenPackage#getEntity_RefEntity()
	 * @model
	 * @generated
	 */
	EList<Entity> getRefEntity();

	/**
	 * Returns the value of the '<em><b>Source Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Column</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Column</em>' reference.
	 * @see #setSourceColumn(Attribute)
	 * @see codegen.CodegenPackage#getEntity_SourceColumn()
	 * @model
	 * @generated
	 */
	Attribute getSourceColumn();

	/**
	 * Sets the value of the '{@link codegen.Entity#getSourceColumn <em>Source Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Column</em>' reference.
	 * @see #getSourceColumn()
	 * @generated
	 */
	void setSourceColumn(Attribute value);

	/**
	 * Returns the value of the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' reference.
	 * @see #setDestination(Attribute)
	 * @see codegen.CodegenPackage#getEntity_Destination()
	 * @model
	 * @generated
	 */
	Attribute getDestination();

	/**
	 * Sets the value of the '{@link codegen.Entity#getDestination <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(Attribute value);

} // Entity
