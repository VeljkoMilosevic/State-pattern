package exceptions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Veljko
 */
public class IllegalStateTransfer extends RuntimeException {


    public IllegalStateTransfer() {
        super("This state transfer is not allowed!");
    }
}
