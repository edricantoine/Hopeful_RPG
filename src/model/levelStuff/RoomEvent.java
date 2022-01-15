package model.levelStuff;

import model.PlayerCharacter;
import model.StatusEffect;

import java.util.List;
import java.util.Random;

public class RoomEvent {
    private double damage;
    private double healing;
    private int apEffect;
    private int apLoss;
    private double atkEffect;
    private double defEffect;
    private StatusEffect statusEffect;
    private int speedEffect;
    private String target;
    private String flavor;


    public RoomEvent(double dmg, double hl, int ap, int apl, double atk, double def, StatusEffect se, int spd, String tgt,
                     String flavor) {
        this.damage = dmg;
        this.healing = hl;
        apEffect = ap;
        apLoss = apl;
        atkEffect = atk;
        defEffect = def;
        statusEffect = se;
        speedEffect = spd;
        target = tgt;
        this.flavor = flavor;

    }

    public String getFlavor() {
        return flavor;
    }

    public void takeEffect(List<PlayerCharacter> party) {
        if(target.equals("one")) {
            Random rand = new Random();
            int chosenTarget = rand.nextInt(party.size());
            party.get(chosenTarget).takeDamage(damage);
            party.get(chosenTarget).healDamage(healing);
            party.get(chosenTarget).healAp(apEffect);
            party.get(chosenTarget).useAp(apLoss);
            if(atkEffect!= 1.0) {
                if(party.get(chosenTarget).getAtkMod() + atkEffect <= 0.25) {
                    party.get(chosenTarget).setAtkMod(0.25);
                } else if (party.get(chosenTarget).getDefMod() + atkEffect>= 4.00) {
                    party.get(chosenTarget).setAtkMod(4.00);
                } else {
                    party.get(chosenTarget).setAtkMod((party.get(chosenTarget).getAtkMod() + atkEffect));
                }

            }

            if(defEffect!= 1.0) {
                if(party.get(chosenTarget).getDefMod() + defEffect <= 0.25) {
                    party.get(chosenTarget).setDefMod(0.25);
                } else if (party.get(chosenTarget).getDefMod() + defEffect >= 4.00) {
                    party.get(chosenTarget).setDefMod(4.00);
                } else {
                    party.get(chosenTarget).setDefMod((party.get(chosenTarget).getDefMod() + defEffect));
                }

            }
            party.get(chosenTarget).setCurrentStatus(statusEffect);
            party.get(chosenTarget).setSpeed(party.get(chosenTarget).getSpeed() + speedEffect);
        } else {
            for(PlayerCharacter p : party) {
                p.takeDamage(damage);
                p.healDamage(healing);
                p.healAp(apEffect);
                p.useAp(apLoss);
                p.setAtkMod(p.getAtkMod() + atkEffect);
                p.setDefMod(p.getDefMod() + defEffect);
                p.setCurrentStatus(statusEffect);
                p.setSpeed(p.getSpeed() + speedEffect);
            }
        }
    }


}
