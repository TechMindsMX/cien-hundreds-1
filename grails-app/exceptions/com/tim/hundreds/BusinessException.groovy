package com.tim.hundreds

class BusinessException extends Exception {

  BusinessException(){
    super()
  }

  BusinessException(String msg){
    super(msg)
  }

  BusinessException(String msg, Throwable cause) {
    super(msg, cause)
  }

}
