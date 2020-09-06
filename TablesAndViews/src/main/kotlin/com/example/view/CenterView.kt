package com.example.view

import com.example.controllers.MainController
import com.example.models.Student
import com.example.models.StudentModel
import tornadofx.*

class CenterView : View("My View") {

    private val mainController: MainController by inject()
    private val studentModel: StudentModel by inject()

    override val root = tableview<Student> {
        items = mainController.students

        isEditable = true

        column("ID", Student::idProperty)
        column("First Name", Student::firstNameProperty)
        column("Last Name", Student::lastNameProperty)
        readonlyColumn("Age", Student::age)

        bindSelected(studentModel)

    }
}
