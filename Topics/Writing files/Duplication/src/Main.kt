val fileName = "MyFile.txt"// Write your code here. Do not import any libraries
val inputString = readLine()!!
val myFile = File(fileName)
myFile.writeText(inputString)
myFile.appendText(inputString)