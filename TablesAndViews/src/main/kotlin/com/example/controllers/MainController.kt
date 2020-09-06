package com.example.controllers

import com.example.models.Student
import javafx.collections.FXCollections
import tornadofx.*
import java.time.LocalDate

class MainController: Controller() {

    companion object {
        var nextId = 0
        get() {
            field++
            return field
        }
    }

    val names = FXCollections.observableArrayList<String>(
            "Nicolle dos Santos",
            "Gabriel Ostermann",
            "Otto Fernandes",
            "Suzanny Kuhlmann",
            "Vitoria Reyes"
    )

    val students = FXCollections.observableArrayList<Student>(
            Student(nextId, "Nicolle", "Dos Santos",
                    LocalDate.of(2000, 8, 2)),
            Student(nextId, "Gabriel", "Ostermann",
                    LocalDate.of(2001, 3, 28)),
            Student(nextId, "Otto", "Fernandes",
                    LocalDate.of(2000, 10, 30)),
            Student(nextId, "Suzanny", "Kuhlmann",
                    LocalDate.of(2004, 2, 14)),
            Student(nextId, "Vitoria", "Reyes",
                    LocalDate.of(2003, 3, 11))
    )

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun addStudent(firstName: String?, lastName: String?, birthday: LocalDate?) {
        if(isInvalid(firstName, lastName, birthday)) return
        val student = Student(nextId, firstName!!, lastName!!, birthday!!)
        addStudent(student)
    }

    fun addName(name: String) {
        names.add(name)
    }

    private fun isInvalid(firstName: String?, lastName: String?, birthday: LocalDate?): Boolean {
        if (firstName == null || lastName == null || birthday == null) return true
        return (firstName.trim().isEmpty() || lastName.trim().isEmpty() || birthday.isAfter(LocalDate.now()))
    }
}