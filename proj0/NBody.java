public class NBody{
	public static double readRadius(String file){
		In in =new In(file);
		int first=in.readInt();
		double second=in.readDouble();
		return second;
	}
	public static Body[] readBodies(String file){
		int N;
		double radius;
		double xP,yP,xV,yV,mass;
		String fileName;

		In in=new In(file);
		N=in.readInt();
		radius=in.readDouble();

		Body[] allBodys=new Body[N];
		for(int i=0;i<N;i++){
			xP=in.readDouble();
			yP=in.readDouble();
			xV=in.readDouble();
			yV=in.readDouble();
			mass=in.readDouble();
			fileName=in.readString();

			allBodys[i]=new Body(xP,yP,xV,yV,mass,fileName);
		}
		return allBodys;
	}
	public static void main(String[] args){
		double T,dt;
		T=Double.parseDouble(args[0]);
		dt=Double.parseDouble(args[1]);
		String filename;
		filename=args[2];

		double radius=readRadius(filename);
		Body[] allBodys=readBodies(filename);
		int N=allBodys.length;
		double[] xForces=new double[N];
		double[] yForces=new double[N];

		//* start drawing*/
		StdDraw.enableDoubleBuffering();
		StdDraw.setXscale(-radius,radius);
		StdDraw.setYscale(-radius,radius);

		StdDraw.picture(0,0,"./images/starfield.jpg");
		for(int i=0;i<allBodys.length;i++){
			allBodys[i].draw();
		}
		StdDraw.show();

		for(double t=0.0;t<T;t=t+dt){
			//*calculate the data and update */
			for(int i=0;i<N;i++){
				xForces[i]=allBodys[i].calcNetForceExertedByX(allBodys);
				yForces[i]=allBodys[i].calcNetForceExertedByY(allBodys);
			}
			for(int i=0;i<N;i++){
				allBodys[i].update(dt,xForces[i],yForces[i]);
			}

			StdDraw.clear();
			StdDraw.picture(0,0,"./images/starfield.jpg");
			for(int i=0;i<N;i++){
				allBodys[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
		}
		StdOut.printf("%d\n", allBodys.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < allBodys.length; i++) {
    	StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  allBodys[i].xxPos, allBodys[i].yyPos, allBodys[i].xxVel,
                  allBodys[i].yyVel, allBodys[i].mass, allBodys[i].imgFileName);   
		}
	}

}