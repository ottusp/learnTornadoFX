package com.example.view

import com.example.controllers.MainController
import com.example.models.Student
import tornadofx.*

class CenterView : View("My View") {

    val mainController: MainController by inject()

    override val root = tableview<Student> {
        items = mainController.students

        isEditable = true

        column("ID", Student::idProperty)
        column("First Name", Student::firstNameProperty)
        column("Last Name", Student::lastNameProperty)
        readonlyColumn("Age", Student::age)
    }
}
