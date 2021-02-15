public class CompoundShape
{
	private Rectangle[] parts = new Rectangle[100];
	private int numberParts = 0;

	private double xPosition = 0.0;
	private double yPosition = 0.0;

	public CompoundShape()
	{
	}

	public CompoundShape(double x, double y)
	{
		this.xPosition = x;
		this.yPosition = y;
	}

	public void addRectangle(Rectangle r)
	{
		if (numberParts < parts.length)
		{
			parts[numberParts] = r;
			numberParts++;
		}	
	}

	public void addShapeTo(GameArena a)
	{
		for (int i = 0 ; i < numberParts; i++)
		{
			parts[i].setXPosition(parts[i].getXPosition() + xPosition);
			parts[i].setYPosition(parts[i].getYPosition() + yPosition);
			a.addRectangle(parts[i]);
		}
	}

	public void move(double x, double y)
	{
		xPosition += x;
		yPosition += y;

		for (int i=0; i<numberParts; i++)
		{
			parts[i].setXPosition(parts[i].getXPosition() + x);
			parts[i].setYPosition(parts[i].getYPosition() + y);
		}
	}

	public void moveTo(double x, double y)
	{
		move(x-xPosition, y-yPosition);
		xPosition = x;
		yPosition = y;
	}

	public int getNumberParts()
	{
		return numberParts;
	}

	public Rectangle getPart(int i)
	{
		return parts[i];
	}

	boolean collides (CompoundShape c)
	{
		for (int i=0; i<numberParts; i++)
		{
			for (int j=0; j<c.numberParts; j++)
			{
				if (parts[i].collides(c.getPart(j)))
					return true;
			}
		}

		return false;
	}

	public double getXPosition()
	{
		return xPosition;
	}

	public double getYPosition()
	{
		return yPosition;
	}

	public void removeShapeFrom(GameArena a)
	{
		for (int i=0; i<numberParts; i++)
		{
			a.removeRectangle(parts[i]);
		}
	}
}
