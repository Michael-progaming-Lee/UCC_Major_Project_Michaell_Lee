package com.example.deptofinfotechmobileapp
// Michael Lee ID#20214626
// Iodre Paterson ID#20196143

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.deptofinfotechmobileapp.Course
import com.example.deptofinfotechmobileapp.Course as Course1

class Courses : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        val dbHandler = DatabaseHandler(this)

        val course1 = Course1("ITT420", "Mobile Application Development", 3, "None",
            "This course will introduce students to the core conceptual skills and basic practices needed " +
                    "to develop an Android application.  The course will focus on how the application communicates to " +
                    "retrieve, store and interact with other devices on any android platform. Topics will include memory " +
                    "management, user interface design, user interface building, input methods, data handling, and network " +
                    "techniques.")

        val course2 = Course1("ITT303", "Programming Design Using JAVA", 3, "ITT200 Object Oriented\n" +
                "Programming using C++,", "This introductory course in Java programming exposes the students to the " +
                "fundamental concepts of using Java to develop written and well-structured object-oriented programmes that " +
                "address real-world problems. Students are expected to already know programming in general and specific " +
                "programming knowledge in an object-oriented environment.")

        val course3 = Course1("ITT302", "Operating Systems", 3, "ITT200 Object Oriented\n" +
                "Programming using C++,", "The course introduces operating systems design and implementation " +
                "fundamentals. Topics include an overview of the components of an operating system, mutual exclusion and " +
                "synchronization, implementation of processes, scheduling algorithms, memory management, and file systems. " +
                "The course explains the issues that influence the design of contemporary operating systems and may include " +
                "a laboratory component to enable students to experiment with operating systems.")

        val course4 = Course1("ITT405", "Human Computer Interaction and Interface Design", 3, "ITT310 System Analysis and Design," +
                "\nPSY100 Introduction to Psychology ", " ")

        val course5 = Course1("ITT307", "Internet Authoring II", 3, "ITT208 Internet Authoring I",
            "This course continues from Internet Authoring I, covering some of the same topics in more depth. This " +
                    "course includes coverage of topics in networking technologies for the web, web UI design and site design, " +
                    "client-server architecture and client-side and server-side programming. It covers relevant topics in " +
                    "e-commerce, web security, and engineering concepts such as the three-tier architecture and frameworks for" +
                    " the web. It provides an introduction to mobile web issues and web multimedia. ")

        val course6 = Course1("ITT201", "Data Communication & Networks", 3, "ITT101 Computer Information",
            " ")

        val course7 = Course1("SOC101", "Introduction to Sociology", 3, "None",
            "This introductory course seeks to provide an overview of Sociology as a discipline. " +
                    "It lays the foundation for the students to apply the various theoretical perspectives to " +
                    "contemporary social problems especially as it relates to the world of work.")

        val course8 = Course1("ITT116", "Computer Essentials & Troubleshooting I", 3, "None",
            " ")

        val course9 = Course1("SPA101", "Introduction to Spanish", 3, "None",
            " ")

        val course10 = Course1("UCC101", "Orientation to University Life", 1, "None",
            " ")
// Add more courses as needed

        dbHandler.addCourse(course1)
        dbHandler.addCourse(course2)
        dbHandler.addCourse(course3)
        dbHandler.addCourse(course4)
        dbHandler.addCourse(course5)
        dbHandler.addCourse(course6)
        dbHandler.addCourse(course7)
        dbHandler.addCourse(course8)
        dbHandler.addCourse(course9)
        dbHandler.addCourse(course10)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val courses = dbHandler.getAllCourses()
        recyclerView.adapter = CourseAdapter(courses)

    }
}