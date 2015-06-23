package com.tim.hundreds

class Video {
  String uuid = TokenService.generateToken()
  String url

  static belongsTo = [
    musician : Musician
  ]

  static constraints = {
    url(blank:false,size:10..100,url:true, validator: {val,obj -> 
	    	if (val ==~ /(?:[hH][tT]{2}[pP][sS]{0,1}:\/\/)?[wW]{0,3}\.{0,1}[yY][oO][uU][tT][uU](?:\.[bB][eE]|[bB][eE]\.[cC][oO][mM])?\/(?:(?:[wW][aA][tT][cC][hH])?(?:\/)?\?(?:.*)?[vV]=([a-zA-Z0-9--]+).*|([A-Za-z0-9--]+))/) {
	    		return true
	    	} else if (val ==~ /https?:\/\/(?:www\.)?(vimeo|youtube)\.com\/(?:watch\?v=)?(.*?)(?:\z|$|&)/){
	    		return true
	    	}
	    	 else {
	    		return false
	    	}
	    }
	  )
	}

}
