package model;

public void addXP(int xp) {
    this.currentXP += xp;
    this.totalXP += xp;
    // si currentXP dépasse le seuil du prochain niveau → level++, mettre à jour le titre
} 