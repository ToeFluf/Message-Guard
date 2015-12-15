# Message-Guard
The problem lies some where within the Image_Activity.java file because it repeadetly gives me a null pointer exception when i call: 
  private void addTouchListener() {
	        ImageView image = (ImageView) findViewById(R.id.mainImage);
	 
	        image.setOnTouchListener(pointCollector);
	    }
And when i call

addTouchListener();

Because every time it comes with the emulator error NullPointerException cant be called on an empty object but I cannot figure out what value is null.
