package com.example.myquizapp2


object QuestionAnswer {
    var question: Array<String> = arrayOf(
        "What is 10+26 ?",
        "Who invented Telephone?",
        "What is 12*9 ?",
        "Who is the founder of SpaceX ?",
        "In the given options,which is the example of System Software ?",

        )

    var choices: Array<Array<String>> = arrayOf(
        arrayOf("32", "42", "36", "38"),
        arrayOf("Graham Bell", "Einstein", "Edison", "None of the above"),
        arrayOf("96", "84", "102", "108"),
        arrayOf("Jeff Bezos", "Elon Musk", "Steve Jobs", "Bill Gates"),
        arrayOf("windows", "Linux", "MacOs", "All of the above"),
    )
    var correctAnswers: Array<String> = arrayOf(
        "36",
        "Graham Bell",
        "108",
        "Elon Musk",
        "All of the above",
    )
}