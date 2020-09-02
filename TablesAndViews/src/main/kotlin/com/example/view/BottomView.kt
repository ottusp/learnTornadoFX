package com.example.view

import com.example.controllers.MainController
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class BottomView : View("My View") {

    private val mainController: MainController by inject()

    private val firstName = SimpleStringProperty()
    private val lastName = SimpleStringProperty()

    override val root = form {
        fieldset {
            field ("First name") {
                textfield (firstName)
            }
        }

        fieldset {
            field ("Last name") {
                textfield (lastName)
            }
        }

        button {
            text = "Save student"
            action {
                if(firstName.value.isNullOrBlank() || lastName.value.isNullOrBlank()) {
                    // do nothing
                } else {
                    val name = "${firstName.value} ${lastName.value}"

                    mainController.addName(name)

                    firstName.value = ""
                    lastName.value = ""
                }
            }
        }
    }
}
