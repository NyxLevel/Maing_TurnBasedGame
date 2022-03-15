package com.example.maing_turnbasedgame;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Controller {
    int turnNumber = 1;
    int random, store;
    Random randomizer = new Random();

    public Controller() {
    }

    public void Turn(TextView announce, TextView damage, ImageView juvskill, ImageView btnnext, ImageView btnrestart, JUV mc, GRF gray) {
        damage.setVisibility(View.VISIBLE);
        switch (turnNumber % 2) {
            case (1): //juv
                random = randomizer.nextInt(mc.getMaxDamage() - mc.getMinDamage()) + mc.getMinDamage();
                store = random;
                gray.setHealth(gray.getHealth() - store);
                damage.setText("Juvia   dealt  " + String.valueOf(mc.getSkilldamage()) + "  to   the   Gray");
                announce.setText("It's   Gray   Fullbuster's   turn");
                turnNumber++;
                hideskill(juvskill);
                mc.setMana(mc.getMana() + 5);
                if (gray.getHealth() <= 0) {
                    gray.setHealth(0);
                    announce.setText("You   defeated   Gray");
                    hideskill(juvskill);
                    hidebutton(btnnext);
                    showrestart(btnrestart);
                    turnNumber = 1;
                }
                break;
            case (0): //gray
                random = randomizer.nextInt(gray.getMaxDamage() - gray.getMinDamage()) + gray.getMinDamage();
                store = random;
                mc.setHealth(mc.getHealth() - store);
                damage.setText("Gray   dealt  " + String.valueOf(store) + "  to   the   Juvia");
                announce.setText("It's   Juvia   Lockser's   turn");
                turnNumber++;
                showskill(juvskill);
                if (mc.getHealth() <= 0) {
                    mc.setHealth(0);
                    announce.setText("You   lost!");
                    hideskill(juvskill);
                    hidebutton(btnnext);
                    showrestart(btnrestart);
                    turnNumber = 1;
                }
                break;
        }
    }

    public void skill(TextView announce, TextView damage, ImageView juvskill, ImageView btnnext, ImageView btnrestart, JUV mc, GRF gray) {
        if (mc.getMana() < 10) {
            hideskill(juvskill);
            announce.setText("You have insufficient mana");
        } else {
            gray.setHealth(gray.getHealth() - mc.getSkilldamage());
            damage.setText("Juvia   dealt  " + String.valueOf(mc.getSkilldamage()) + "  to   the   Gray");
            announce.setText("It's   Gray   Fullbuster's   turn");
            mc.setMana(mc.getMana() - 10);
            hideskill(juvskill);
            turnNumber++;
            if (gray.getHealth() <= 0) {
                gray.setHealth(0);
                announce.setText("You   defeated   Gray");
                hideskill(juvskill);
                hidebutton(btnnext);
                showrestart(btnrestart);
                turnNumber = 1;
            }
        }
    }

    public void reset(TextView announce, TextView damage, ImageView juvskill, ImageView btnnext, ImageView btnrestart, JUV mc, GRF gray) {
        showskill(juvskill);
        showbutton(btnnext);
        announce.setText("It's   Juvia   Lockser's   turn");
        mc.reset();
        gray.reset();
        hiderestart(btnrestart);
    }

    public void hideskill(ImageView juvskill) { juvskill.setVisibility(View.INVISIBLE); }
    public void showskill(ImageView juvskill) { juvskill.setVisibility(View.VISIBLE); }
    public void hidebutton(ImageView btnnext) { btnnext.setVisibility(View.INVISIBLE); }
    public void showbutton(ImageView btnnext) { btnnext.setVisibility(View.VISIBLE); }
    public void hiderestart(ImageView btnrestart) { btnrestart.setVisibility(View.INVISIBLE); }
    public void showrestart(ImageView btnrestart) { btnrestart.setVisibility(View.VISIBLE);}
}
