package com.library.common
import com.library.*;

def gitClone(branchName,url) {
     git branch: "${branchName}", 
     credentialsId: 'gitpat',
     url: "${url}"
   
}