/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dependencyinjection.Features.Default;

import dependencyinjection.MVC.IController;

/**
 *
 * @author david
 */
public class Feature {
    
    private FeatureView view = null;
    
    private FeatureModel model = null;
    
    private FeatureController controller = null;
    
    private FeatureDelegate delegate = null;
    
    public Feature(){
        
        this.delegate = new FeatureDelegate();
        this.controller = new FeatureController();
        
        this.view = new FeatureView();
        this.view.delegate = this.delegate;
        this.controller.loadView(this.view);
        
        this.model = new FeatureModel();
        
    
    }
    
    public Feature( FeatureView view , FeatureModel model , FeatureController controller  )
    {
        this.view = view;
        
        this.model = model;
        this.controller = controller;
        
        this.controller.loadView(this.view);
    }
    
    
    public FeatureController getController()
    {
        return this.controller;
    }
    
    public void execute()
    {
        this.controller.getView().display();
    }
            
    
    
}
