/** Wants paramaters: item's description and file name without .txt ending (which is the item's name in lower case)
    * The method tries to find a text file containing ASCII art for the the item. If the art is found
    * it outputs the image and the description.
    * If the file can't be found, return just the description*/

  def fileToText(string: String, fileName: String) =
    if File(s"foo/$fileName.txt").exists() then
      val file = Source.fromFile(s"foo/$fileName.txt")
      var output: String = ""
      try
        var lineNumber = 1              // stepper
        for line <- file.getLines do
          output += line + "\n"
          lineNumber += 1
        output + "\n" + string
      finally
        file.close()
    else string
