package com.example.xmlformat

import android.util.Log
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream

class XmlParserHandler {
    private val studentsList = ArrayList<Student>()
    private var text: String? = null

    private var studentName = ""
    private var studentGrade = 0.0
    private var studentid = 0

    fun parse(inputStream: InputStream) : List<Student>{
        try {
            val factory = XmlPullParserFactory.newInstance()
            val parse = factory.newPullParser()
            parse.setInput(inputStream, null)
            var eventType = parse.eventType
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tag = parse.name
                when (eventType) {
                    XmlPullParser.TEXT -> text = parse.text
                    XmlPullParser.END_TAG ->
                        when {
                            tag.equals("id", ignoreCase = true) -> {
                                studentid = text!!.toInt()
                            }
                            tag.equals("name", ignoreCase = true) -> {
                                studentName = text.toString()
                            }
                            tag.equals("grade", ignoreCase = true) -> {
                                studentGrade = text!!.toDouble()
                            }
                            else -> studentsList.add(Student(studentid, studentName, studentGrade))
                        }
                    else -> {
                    }
                }
                eventType = parse.next()
            }
        } catch (e: XmlPullParserException) {
           Log.e("XmLE",e.localizedMessage)
        } catch (e: IOException) {
           Log.e("IOE",e.localizedMessage)
        }
        return studentsList
    }
}