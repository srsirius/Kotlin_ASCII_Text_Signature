package signature

import java.io.File
import java.lang.NumberFormatException

fun indexWord(listWord: List<String>, word: Char): Int {
    var result = -1
    if (word == ' ') {
        return result
    } else {
        for (i in listWord.indices) {
            if (listWord[i].first() == word && try {
                    listWord[i].split(" ")[1].toInt()
                    true
                } catch (e: NumberFormatException) { false }) result = i
        }
    }
    return result
}

fun fontChoice(str: String) = File(str).readLines()

fun countString(str: String, list: List<String>): Int {
    var count = 0

    for (ch in str) {
        count += if (indexWord(list, ch) == -1) {
            if (list[0].split(" ")[0].toInt() == 3) {
                5
            } else {
                list[1].split(" ")[1].toInt()
            }
        } else {
            list[indexWord(list, ch)].split(" ")[1].toInt()
        }
    }
    return count
}

fun printBody(list: List<String>, str: String, hight: Int, lengthString: Int = 0) {
    var half = 0
    for (i in 1..hight) {
        if (lengthString > 0 && lengthString % 2 > 0 && countString(str, list) % 2 > 0) {
            half = (lengthString - countString(str, list)) / 2
        } else if (lengthString > 0) half = lengthString / 2 - countString(str, list) / 2 - countString(str, list) % 2
        print("88  ${" ".repeat(half )}")
        for (ch in str) {
            val chIndex = indexWord(list, ch)
            if (chIndex == -1) print(" ".repeat(space(hight))) else print(list[chIndex + i])
            if (half > 0) {
                if (indexWord(list, ch) == -1) {
                    list[1].split(" ")[1].toInt()
                } else {
                    list[indexWord(list, ch)].split(" ")[1].toInt()
                }
            }
        }
        if (half > 0) half = lengthString - (half + countString(str, list))
        println("${" ".repeat(half)}  88")
    }
}

// Space c
fun space(i: Int): Int = if (i == 10) i else 5

fun printCard(strName: String, strStatus: String) {
    val fileNameRoman = "D:\\Intelli IDEA\\ASCII Text Signature\\ASCII Text Signature\\task\\src\\signature\\roman.txt"
    val fileNameMedium = "D:\\Intelli IDEA\\ASCII Text Signature\\ASCII Text Signature\\task\\src\\signature\\medium.txt"

    val lengthName = countString(strName, fontChoice(fileNameRoman))
    val lengthStatus = countString(strStatus, fontChoice(fileNameMedium))

    if (lengthName > lengthStatus) {
        println("8".repeat(lengthName + 8))
        printBody(fontChoice(fileNameRoman), strName, 10)
        printBody(fontChoice(fileNameMedium), strStatus, 3, lengthName)
        print("8".repeat(lengthName + 8))
    } else {
        println("8".repeat(lengthStatus + 8))
        printBody(fontChoice(fileNameRoman), strName, 10, lengthStatus)
        printBody(fontChoice(fileNameMedium), strStatus, 3)
        print("8".repeat(lengthStatus + 8))
    }
}

fun main() {
    print("Enter name and surname: ")
    val name = readLine()!!
    print("Enter person's status: ")
    val status = readLine()!!

    printCard(name, status)
}