public class Body{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static final double G=6.67E-11;

	public Body(double xP,double yP,double xV,double yV,double m,String img){
		this.xxPos=xP;
		this.yyPos=yP;
		this.xxVel=xV;
		this.yyVel=yV;
		this.mass=m;
		this.imgFileName=img;
	}
	public Body(Body b){
		this.xxPos=b.xxPos;
		this.yyPos=b.yyPos;
		this.xxVel=b.xxVel;
		this.yyVel=b.yyVel;
		this.mass=b.mass;
		this.imgFileName=b.imgFileName;
	}

	public double calcDistance(Body b){
		double S=Math.pow((this.xxPos-b.xxPos),2)+Math.pow((this.yyPos-b.yyPos),2);
		return Math.sqrt(S);
	}

	public double calcForceExertedBy(Body b){
		double F=G*this.mass*b.mass/Math.pow(this.calcDistance(b),2);
		return F;
	}

	public double calcForceExertedByX(Body b){
		double Fx=this.calcForceExertedBy(b)*(b.xxPos-this.xxPos)/this.calcDistance(b);
		return Fx;
	}
	public double calcForceExertedByY(Body b){
		double Fy=this.calcForceExertedBy(b)*(b.yyPos-this.yyPos)/this.calcDistance(b);
		return Fy;
	}
	public double calcNetForceExertedByX(Body[] allBodys){
		double FNetX=0.0;
		for(int i=0;i<allBodys.length;i++){
			if(this.equals(allBodys[i])){
				continue;
			}
			FNetX+=this.calcForceExertedByX(allBodys[i]);
		}
		return FNetX;
	}
	public double calcNetForceExertedByY(Body[] allBodys){
		double FNetY=0.0;
		for(int i=0;i<allBodys.length;i++){
			if(this.equals(allBodys[i])){
				continue;
			}
			FNetY+=this.calcForceExertedByY(allBodys[i]);
		}
		return FNetY;
	}
	public void update(double dt,double fX,double fY){
		double aX=fX/this.mass;
		double aY=fY/this.mass;
		this.xxVel+=aX*dt;
		this.yyVel+=aY*dt;
		this.xxPos+=this.xxVel*dt;
		this.yyPos+=this.yyVel*dt;
	}

	public void draw(){
		StdDraw.picture(xxPos,yyPos,this.imgFileName);
	}
}
