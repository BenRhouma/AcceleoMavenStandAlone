/**
 */
package com.sofrecom.codegen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sofrecom.codegen.ViewModel#getID <em>ID</em>}</li>
 *   <li>{@link com.sofrecom.codegen.ViewModel#getEntities <em>Entities</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sofrecom.codegen.CodegenPackage#getViewModel()
 * @model
 * @generated
 */
public interface ViewModel extends EObject {
	/**
	 * Returns the value of the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ID</em>' attribute.
	 * @see #setID(String)
	 * @see com.sofrecom.codegen.CodegenPackage#getViewModel_ID()
	 * @model
	 * @generated
	 */
	String getID();

	/**
	 * Sets the value of the '{@link com.sofrecom.codegen.ViewModel#getID <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ID</em>' attribute.
	 * @see #getID()
	 * @generated
	 */
	void setID(String value);

	/**
	 * Returns the value of the '<em><b>Entities</b></em>' containment reference list.
	 * The list contents are of type {@link com.sofrecom.codegen.Entity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entities</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entities</em>' containment reference list.
	 * @see com.sofrecom.codegen.CodegenPackage#getViewModel_Entities()
	 * @model containment="true"
	 * @generated
	 */
	EList<Entity> getEntities();

} // ViewModel
