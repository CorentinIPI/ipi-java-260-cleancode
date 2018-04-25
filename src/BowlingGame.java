public class BowlingGame {

    private int score=0;
    private int NmLancer=0;
    private int PrecLancer1=0;
    private boolean isSpare=false;
    private boolean isStrike=false;
    private boolean isDoubleStrike=false;

    public int score() {
        return score;
    };

    public void roll(int numberPins) {
    	
    	//Incrémentaion du nombre de lancer
    	NmLancer++;
    	
    	//Test Fin de la partie
    	if(NmLancer<=24) {
    		
    		//Nombre Impair Premier lancer du frame
	    	if(NmLancer%2==1){
	    		
	    		//Save du Lancer
	    		PrecLancer1=numberPins;
	    		
	    		
	    		if(isSpare()) {				//Test du Spare
	    			score += numberPins*2;
	    			isSpare=false;
	    			if(numberPins==10) {
	    				isStrike=true;
	    				NmLancer++;
	    			}
	    		}else if(isStrike() && isDoubleStrike!=true){ //Test de 1 Strike 
	    			score += numberPins*2;
	    			if(numberPins==10) {
	    				isDoubleStrike=true;
	    				NmLancer++;
	    			}
	    		}else if(isDoubleStrike) {   //Test de plusieurs Strike à la suite
	    			if(NmLancer<21) {
		    			score += numberPins*3;
		    			NmLancer++;
		    			if(numberPins != 10) isDoubleStrike=false;
	    			}else {
	    				score += numberPins;
	    			}
	    			
	    		}else if(numberPins==10){
	    			score+= numberPins;
	    			if(NmLancer<19) {
	    				isStrike=true;
	    			}else {
	    				isStrike=false;
	    			}
	    			NmLancer++;
	    		}else {
	    			score+= numberPins;
	    		}
	    		
	    		
	    	}else {
	    		//Gestion du Second lancer
	    		if(PrecLancer1+numberPins==10) {
	    			isSpare=true;
	    			if(isStrike()) {
	    				score += numberPins*2;
	    				isStrike=false;
	    			}else {
	    				score += numberPins;
	    			}
	    			
	    		}else if(isStrike()) {
	    			score += numberPins*2;
	    			isStrike=false;
	    		}else {
	    			score += numberPins;
	    		}
	    		
	    	}
    	}
        
    }

	public int getNmLancer() {
		return NmLancer;
	}

	public void setNmLancer(int nmLancer) {
		NmLancer = nmLancer;
	}

	public int getPrecLancer1() {
		return PrecLancer1;
	}

	public void setPrecLancer1(int precLancer1) {
		PrecLancer1 = precLancer1;
	}

	public boolean isSpare() {
		return isSpare;
	}

	public void setSpare(boolean isSpare) {
		this.isSpare = isSpare;
	}

	public boolean isStrike() {
		return isStrike;
	}

	public void setStrike(boolean isStrike) {
		this.isStrike = isStrike;
	}

}