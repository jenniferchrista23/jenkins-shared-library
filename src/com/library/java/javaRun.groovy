package com.library.java
import com.library.*;

def runProcess() {
    def scriptText = libraryResource "com/library/java/run.sh"
    writeFile file:'run.sh', text:libraryResource("com/library/java/run.sh")
    sh "chmod +x run.sh"
    sh "./run.sh"
}    