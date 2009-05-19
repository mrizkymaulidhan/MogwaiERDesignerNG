/**
 * Mogwai ERDesigner. Copyright (C) 2002 The Mogwai Project.
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package de.erdesignerng.visual.editor.openxavaexport;

import java.awt.Component;

import de.erdesignerng.ERDesignerBundle;
import de.erdesignerng.dialect.Dialect;
import de.erdesignerng.generator.openxava.OpenXavaOptions;
import de.erdesignerng.model.Model;
import de.erdesignerng.visual.editor.BaseEditor;
import de.mogwai.common.client.binding.BindingInfo;
import de.mogwai.common.client.looks.UIInitializer;

/**
 * @author $Author: mirkosertic $
 * @version $Date: 2009-03-13 15:40:33 $
 */
public class OpenXavaExportEditor extends BaseEditor {

    private Model model;

    private BindingInfo<OpenXavaOptions> bindingInfo = new BindingInfo<OpenXavaOptions>(new OpenXavaOptions());

    private OpenXavaExportEditorView editingView;

    /**
     * Create a relation editor.
     * 
     * @param aModel
     *            the model
     * @param aParent
     *            the parent container
     */
    public OpenXavaExportEditor(Model aModel, Component aParent) {
        super(aParent, ERDesignerBundle.OPENXAVAEXPORT);

        initialize();

        model = aModel;

        bindingInfo.addBinding("srcDirectory", editingView.getSrcDirectory(), true);
        bindingInfo.addBinding("packageName", editingView.getPackageName(), true);
//        bindingInfo.addBinding("typeMapping",
  //              new ConvertPropertyAdapter(editingView.getMappingTable(), null, getResourceHelper()));

        bindingInfo.configure();
        bindingInfo.model2view();
    }

    /**
     * Initialize the current mapping model for a target dialect.
     * 
     * @param aDialect
     *            the target dialect
     */
    private void initializeMappingModelFor(Dialect aDialect) {

/*        ConversionInfos theInfos = bindingInfo.getDefaultModel();
        theInfos.setTargetDialect(aDialect);
        theInfos.getTypeMapping().clear();
        
        // Try to map the types
        for (DataType theCurrentType : model.getUsedDataTypes()) {
            theInfos.getTypeMapping().put(theCurrentType, aDialect.findClosestMatchingTypeFor(theCurrentType));
        }*/
    }

    /**
     * This method initializes this.
     */
    private void initialize() {

        editingView = new OpenXavaExportEditorView();
        editingView.getOKButton().setAction(okAction);
        editingView.getCancelButton().setAction(cancelAction);

        setContentPane(editingView);
        setResizable(false);

        pack();

        UIInitializer.getInstance().initialize(this);
    }

    @Override
    protected void commandOk() {
        if (bindingInfo.validate().size() == 0) {
            setModalResult(MODAL_RESULT_OK);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyValues() throws Exception {
    }
}