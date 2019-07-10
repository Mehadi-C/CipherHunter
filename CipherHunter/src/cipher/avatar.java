package cipher;

public class avatar {
	 static int health, attack, defence;

	    avatar(int att, int def, int h)
	    {
	        attack = att;
	        defence= def;
	        health= h;
	    }

	    void avatarIsAttacked(int a){
	        if( a > 0 )
	        {
	            health -= a;
	        }
	        else
	            health += 0;
	    }

	    static int getAttack(){
	        return attack;
	    }

	    static int getHealth(){
	        return health;
	    }

	    static int getDefence(){
	        return defence;
	    }
	    
	    static boolean death()
	    {
	        if( health <= 0 )
	            return true;
	        return false;
	    }
}
