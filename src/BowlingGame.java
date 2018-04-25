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
    	
    	if(NmLancer%2==1){
    		
    	
    		PrecLancer1=numberPins;
    		if(isSpare()) {
    			score += numberPins*2;
    			isSpare=false;
    			if(numberPins==10) {
    				isStrike=true;
    				NmLancer++;
    			}
    		}else if(isStrike() && isDoubleStrike!=true){
    			score += numberPins*2;
    			if(numberPins==10) {
    				isDoubleStrike=true;
    				NmLancer++;
    			}
    		}else if(isDoubleStrike && NmLancer<=21) {
    			score += numberPins*3;
    			NmLancer++;
    			if(numberPins != 10) isDoubleStrike=false;
    		}else if(numberPins==10){
    			score+= numberPins;
    			if(NmLancer<=21) isStrike=true;
    			NmLancer++;
    		}else {
    			score+= numberPins;
    		}
    		
    		
    	}else {
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