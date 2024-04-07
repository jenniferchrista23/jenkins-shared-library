package com.library.java
import com.library.*;

def variable() {
    env.url = "https://dev.azure.com/christajennifer/java-sample-project/_git/java-sample-project"
    env.goals = "-s settings.xml clean package"
}    