/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package avltree;

/**
 *
 * @author Lavanya
 */
 class AVLNode
    {
            // Constructors
        AVLNode( Comparable theElement )
        {
            this( theElement, null, null );
        }

        AVLNode( Comparable theElement, AVLNode lt, AVLNode rt )
        {
            element  = theElement;
            left     = lt;
            right    = rt;
            height   = 0;
        }

            // Friendly data; accessible by other package routines
        Comparable element;      // The data in the node
        AVLNode    left;         // Left child
        AVLNode    right;        // Right child
        int        height;       // Height
    }