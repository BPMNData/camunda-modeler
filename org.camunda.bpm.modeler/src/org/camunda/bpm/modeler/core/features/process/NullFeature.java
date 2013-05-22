package org.camunda.bpm.modeler.core.features.process;

import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IRemoveContext;

public class NullFeature implements IDeleteFeature, IRemoveFeature, IMoveShapeFeature {

	@Override
	public boolean isAvailable(IContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canExecute(IContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void execute(IContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canUndo(IContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasDoneChanges() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFeatureProvider getFeatureProvider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canDelete(IDeleteContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void preDelete(IDeleteContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(IDeleteContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postDelete(IDeleteContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canRemove(IRemoveContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void preRemove(IRemoveContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(IRemoveContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postRemove(IRemoveContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canMoveShape(IMoveShapeContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void moveShape(IMoveShapeContext context) {
		// TODO Auto-generated method stub
		
	}

}
