package cipher;

class avatar {
	
	 int health, attack, defence;

	    avatar(int att, int def, int h)
	    {
	        attack = att;
	        defence= def;
	        health= h;
	    }

	    public void avatarIsAttacked(int a){
	            health -= a;
	    }

	    public int getAttack(){
	        return attack;
	    }

	    public int getHealth(){
	    	
	        return health;
	    }

	    int getDefence(){
	        return defence;
	    }
	    
//	    static boolean death()
//	    {
//	        if( health <= 0 )
//	            return true;
//	        return false;
//	    }
}
