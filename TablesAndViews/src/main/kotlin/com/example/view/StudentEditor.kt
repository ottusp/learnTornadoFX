package com.example.view

import com.example.controllers.MainController
import com.example.models.Student
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.time.LocalDate

class StudentEditor : View("My View") {

    private val mainController: MainController by inject()

    private val firstName = SimpleStringProperty()
    private val lastName = SimpleStringProperty()
    private val birthday = SimpleObjectProperty<LocalDate>()

    override val root = form {
        fieldset {
            field ("First name"){
                textfield (firstName)
            }
            field ("Last name"){
                textfield (lastName)
            }
            field ("Date of birth") {
                datepicker (birthday)
            }
        }

        button("Save") {
            action {
                mainController.addStudent(firstName.value, lastName.value, birthday.value)

                firstName.value = ""
                lastName.value = ""
                birthday.value = null
            }
        }
    }
}
