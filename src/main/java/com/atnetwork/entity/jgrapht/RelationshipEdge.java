/**
 * 
 */
package com.atnetwork.entity.jgrapht;

import org.jgrapht.graph.DefaultEdge;

/**
 * @author weiwei
 *
 */
public class RelationshipEdge extends DefaultEdge {
	private String label;
	public static final String default_label="default";

    /**
     * Constructs a relationship edge
     *
     * @param label the label of the new edge.
     * 
     */
    public RelationshipEdge(String label)
    {
        this.label = label;
    }

    /**
     * Gets the label associated with this edge.
     *
     * @return edge label
     */
    public String getLabel()
    {
        return label;
    }
    
    /**
     * Set the label with params
     * @param label
     */
    public void setLabel(String label) {
    	this.label = label;
    }

    @Override
    public String toString()
    {
        return "(" + getSource() + " : " + getTarget() + " : " + label + ")";
    }
}
