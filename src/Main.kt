fun main() {
    println("Введите количество строк:")
    val rows = readLine()!!.toInt()
    println("Введите количество столбцов:")
    val cols = readLine()!!.toInt()
//Считывание и преобразование строки в целое число (!! гарантирует, что она не равна null)

    val array = Array(rows) { IntArray(cols) } //Создание двумерного массива

    println("Введите $rows строк по $cols трехзначных чисел:")
    for (i in 0 until rows) { //Начинает цикл по строкам массива
        for (j in 0 until cols) { //Начинает цикл по столбцам массива

            var number: Int //Переменная number будет хранить введенное трехзначное число.

            do {
                println("Введите трехзначное число для позиции [$i][$j]:")
                val input = readLine()!!.trim() //Считывает строку и убирает лишние пробелы

                try { //В случае ошибки запрашивает у пользователя повторный ввод
                    number = input.toInt()
                    if (number in 100..999) { //Проверка на трехзначное число
                        array[i][j] = number
                    } else {
                        println("Число должно быть трехзначным. Пожалуйста, попробуйте снова.")
                    }
                } catch (e: NumberFormatException) {
                    println("Некорректный ввод. Пожалуйста, введите целое число.")
                    number = -1 // Устанавливаем число в некорректное значение, чтобы цикл продолжался
                }
            } while (number < 100 || number > 999) // Выполняет цикл пока число не будет трехзначным
        }
    }

    println("Введенный двумерный массив:")
    for (row in array) {
        for (num in row) {
            print("$num ")
        }
        println()
    }

    val uniqueDigits = mutableSetOf<Char>() //Создает пустое изменяемое множество

    for (i in 0 until rows) {
        for (j in 0 until cols) {

            val digits = array[i][j].toString() // Преобразование числа в строку
            for (digit in digits) { //Внутренний цикл перебирает каждый символ (цифру) в строке
                uniqueDigits.add(digit) // Подсчет уникальных цифр
            }
        }
    }


    println("В массиве использовано ${uniqueDigits.size} различных цифр")
}