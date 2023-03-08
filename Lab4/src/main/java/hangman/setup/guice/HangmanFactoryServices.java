/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.setup.guice;

/**
 *
 * @author 2106913
 */
import hangman.model.Language;
import hangman.model.French;
import hangman.model.Spanish;
import hangman.model.English;

import hangman.model.dictionary.HangmanDictionary;
import hangman.model.dictionary.FrenchDictionaryDataSource;
import hangman.model.dictionary.SpanishDictionaryDataSource;
import hangman.model.dictionary.EnglishDictionaryDataSource;

import hangman.view.HangmanPanel;
import hangman.view.HangmanNoviolentoPanel;
import hangman.view.HangmanStickmanPanel;
import hangman.view.HangmanColoridoPanel;

import hangman.model.GameScore;
import hangman.model.OriginalScore;
import hangman.model.BonusScore;
import hangman.model.PowerBonusScore;


public class HangmanFactoryServices extends com.google.inject.AbstractModule {

    @Override
    protected void configure() {
        /* Guice dependency injection */
        bind(Language.class).to(French.class);
		bind(HangmanDictionary.class).to(FrenchDictionaryDataSource.class);
		bind(HangmanPanel.class).to(HangmanNoviolentoPanel.class);
		bind(GameScore.class).to(BonusScore.class);
    }

}
