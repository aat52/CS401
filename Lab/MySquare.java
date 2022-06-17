public class MySquare extends MyRectangle{

	public MySquare(){
		this(0,0,0);
	}
	
		  // Constructors to allow new objects to be created. x and y are the
		  // location coordinates and size is the side length
	public MySquare(int x, int y, int side){
		super(x, y, side, side);
	}
		
		// Redefining toString().  See output for effect.
	public String toString(){
		StringBuilder S = new StringBuilder();
		S.append(" Side: " + width);
		S.append(" X: " + startX);
		S.append(" Y: " + startY);
		
		return S.toString();
	}
		  
		  // Redefining setSize().  This must be done because the inherited version
		  // allows the width and height to differ but in a square they must be the
		  // same.  In this version, if the width and height are not the same, the
		  // method should output a message and not change anything.
	public void setSize(int w, int h){
		width = w;
		height = h;
		if (w != h){
			System.out.println("Sides must be equal. " + w + " != " + h + " so no action taken");
		}
	}

		  // This is a new method that updates that size of the square.  Think about
		  // how this will be implemented using the existing inherited instance vars.
	public void setSide(int side){
		if (width == height){
			width = side;
			height = side;
		}
	}
  }
