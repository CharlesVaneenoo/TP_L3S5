package jade;

import java.io.IOException;

/**
 *  A JadeParser parses and plays Jade commands.
 *
 *  a JadeParser implementation typically implements a constructor  :
 *   (jadelex.Tokenizer tokenizer, jade.JadeMachine machine)
 *
 */

interface JadeParser{
    void run() throws IOException, JadeException;
}