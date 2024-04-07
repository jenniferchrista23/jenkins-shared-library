package com.library.common
import com.library.*;

def maven(def goals) {
        sh "mvn ${goals}"
}        
