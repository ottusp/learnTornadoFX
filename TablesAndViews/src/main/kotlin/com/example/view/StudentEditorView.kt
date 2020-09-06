package com.example.view

import com.example.controllers.MainController
import com.example.models.Student
import com.example.models.StudentModel
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Insets
import javafx.scene.input.KeyCode
import tornadofx.*
import java.time.LocalDate

class StudentEditorView : View("My View") {

    private val mainController: MainController by inject()
    private val studentModel: StudentModel by inject()


    override val root = form {
        fieldset {
            field ("First name"){
                textfield (studentModel.firstName).required()
            }
            field ("Last name"){
                textfield (studentModel.lastName).required()
            }
            field ("Date of birth") {
                datepicker (studentModel.birthday).required()
            }
        }

        borderpane {

            paddingHorizontal = 15.0

            left = button("Save") {
                enableWhen(studentModel.valid)
                action {
                    submitData()
                }
            }

            right = button("Reset") {
                enableWhen(studentModel.dirty)
                action {
                    studentModel.rollback()
                }
            }
        }


        setOnKeyPressed {
            if(it.code == KeyCode.ENTER)
                submitData()
        }
    }

    private fun submitData() {
        mainController.addStudent(
                studentModel.firstName.value,
                studentModel.lastName.value,
                studentModel.birthday.value
        )

        studentModel.firstName.value = ""
        studentModel.lastName.value = ""
        studentModel.birthday.value = null
    }
}
