class MultithreadDemo
{
	public static void main(String args[])
	{
		int n=8;
		for(int i=0;i<n;i++)
		{
			Multithread object=new Multithread();
			object.start();
		}
	}
}