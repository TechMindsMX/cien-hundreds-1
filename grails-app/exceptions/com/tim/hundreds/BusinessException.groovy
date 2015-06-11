package com.tim.hundreds

class BusinessException extends RuntimeException {

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
