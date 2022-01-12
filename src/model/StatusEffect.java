package model;

public enum StatusEffect {
    BURNED, NUMB, POISONED, AFRAID, RIPOSTE, NONE
}

//BURNED: 10 dmg / turn for 3 turns
//NUMB: cannot move for current turn and turn after
//POISONED: 21 damage, 14 damage, 7 damage, then wears off
//AFRAID: increases damage taken and decreases attack a little every turn for 3 turns
//RIPOSTE: attackers take damage equal to damage dealt. Does not wear off naturally.
//NONE: no status effect
