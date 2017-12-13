package org.phoenix.web.controller;

import org.phoenix.enums.DataTemplateDataType;
import org.phoenix.enums.DataTemplateFieldTestType;
import org.phoenix.model.DataTemplateBean;
import org.phoenix.model.DataTemplateFieldBean;
import org.phoenix.web.dto.DataTemplateDTO;
import org.phoenix.web.dto.DataTemplateFieldDTO;
import org.phoenix.web.service.impl.DataTemplateService;
import org.phoenix.web.util.EnumUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.phoenix.web.auth.AuthClass;
import org.phoenix.web.model.User;
import org.phoenix.web.service.IDataTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Kemi on 2017/9/23.
 * Description:数据模板的controller
 */
@Controller
@RequestMapping("/dataTemplate")
@AuthClass("login")
public class DataTemplateController {


   IDataTemplateService dataTemplateService = new DataTemplateService();


    @RequestMapping("/list")
    public String list(Model model, HttpSession httpSession){
        User u = (User)httpSession.getAttribute("loginUser");
        model.addAttribute("datas", dataTemplateService.getDataTemplateBeanPager(u.getId()));
        return "dataTemplate/list";
    }

    @RequestMapping(value="/select",method=RequestMethod.GET)
    public String select(String keyWord,String keyWord2,Model model,HttpSession session){
        User u = (User)session.getAttribute("loginUser");
        model.addAttribute("keyWord", keyWord);
        model.addAttribute("keyWord2", keyWord2);
        model.addAttribute("datas", dataTemplateService.getDataTemplateBeanPagerByKeyWord(u.getId(), keyWord));
        return "dataTemplate/list";
    }
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public String add(Model model){
        model.addAttribute(new DataTemplateDTO());
        model.addAttribute("templateDataType", EnumUtils.enumProp2NameMap(DataTemplateDataType.class,"name"));
        return "dataTemplate/add";
    }
 	@RequestMapping(value="/add",method= RequestMethod.POST)
 	public String add(@Valid DataTemplateDTO scenarioDTO, BindingResult br, HttpSession httpSession,Model model){
        if(br.hasErrors()){
            model.addAttribute("templateDataType", EnumUtils.enumProp2NameMap(DataTemplateDataType.class,"name"));
            return "dataTemplate/add";
            }
        User u = (User)httpSession.getAttribute("loginUser");
        DataTemplateBean scenarioBean = new DataTemplateBean();
        scenarioBean.setName(scenarioDTO.getName());
        scenarioBean.setType(scenarioDTO.getType());
        scenarioBean.setDescription(scenarioDTO.getDescription());
        dataTemplateService.add(scenarioBean);
        return "redirect:/dataTemplate/list";
        }
 	@RequestMapping("/delete/{id}")
 	public String delete(@PathVariable Integer id){
        dataTemplateService.deleteDataTemplate(id);
        return "redirect:/dataTemplate/list";
        }
 	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
 	public String update(@PathVariable Integer id,Model model){

        model.addAttribute("dataTemplateBean", dataTemplateService.getDataTemplateById(id));
        model.addAttribute("dataTemplateDTO", new DataTemplateDTO());
        model.addAttribute("templateDataType", EnumUtils.enumProp2NameMap(DataTemplateDataType.class,"name"));
        return "dataTemplate/edit";
        }
 	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
 	public String update(@PathVariable Integer id,@Valid DataTemplateDTO dataTemplateDTO,BindingResult br,Model model){
        if(br.hasErrors()){
            return "dataTemplate/edit";
            }
        DataTemplateBean scenarioBean = dataTemplateService.getDataTemplateById(id);
        scenarioBean.setName(dataTemplateDTO.getName());
        scenarioBean.setType(dataTemplateDTO.getType());
        scenarioBean.setDescription(dataTemplateDTO.getDescription());
        dataTemplateService.updataDataTemplate(scenarioBean);
        return "redirect:/dataTemplate/list";
        }
 	//----------------------------------------------
     @RequestMapping("/field/{tid}/list")
 	 public String fieldList(@PathVariable Integer tid, Model model, HttpSession httpSession){
        User u = (User)httpSession.getAttribute("loginUser");
        model.addAttribute("dataTemplateBean", dataTemplateService.getDataTemplateById(tid));
        return "dataTemplate/field_list";
        }
 	@RequestMapping(value="/field/{id}/add",method=RequestMethod.GET)
 	public String fieldAdd(@PathVariable Integer id,Model model){
        model.addAttribute("dataTemplateBean", dataTemplateService.getDataTemplateById(id));
        model.addAttribute(new DataTemplateFieldDTO());
        return "dataTemplate/field_add";
        }
 	@RequestMapping(value="/field/{id}/add",method= RequestMethod.POST)
 	public String fieldAdd(@PathVariable Integer id,@Valid DataTemplateFieldDTO scenarioDTO, BindingResult br, HttpSession httpSession,Model model){
        if(br.hasErrors()){
            model.addAttribute("dataTemplateFieldTestType", EnumUtils.enumProp2NameMap(DataTemplateFieldTestType.class,"name"));
            return "dataTemplate/field_add";
            }
        User u = (User)httpSession.getAttribute("loginUser");
        DataTemplateFieldBean dataTemplateFieldBean = new DataTemplateFieldBean();
        dataTemplateFieldBean.setTestType(scenarioDTO.getTestType());
        dataTemplateFieldBean.setDataContent(scenarioDTO.getDataContent());
        dataTemplateFieldBean.setDataTemplateBean(dataTemplateService.getDataTemplateById(id));
        dataTemplateService.add(dataTemplateFieldBean);
        return "redirect:/dataTemplate/field/"+id+"/list";
        }
 	//    @RequestMapping("/delete/{id}")
            //    public String delete(@PathVariable Integer id){
           //        dataTemplateService.deleteDataTemplate(id);
            //        return "redirect:/dataTemplate/list";
            //    }
            //
            //    @RequestMapping(value="/update/{id}",method=RequestMethod.GET)
           //    public String update(@PathVariable Integer id,Model model){
            //        model.addAttribute("dataTemplateBean", dataTemplateService.getDataTemplateById(id));
            //        model.addAttribute("dataTemplateDTO", new DataTemplateDTO());
            //        return "dataTemplate/edit";
            //    }
            //    @RequestMapping(value="/update/{id}",method=RequestMethod.POST)
            //    public String update(@PathVariable Integer id,@Valid DataTemplateDTO dataTemplateDTO,BindingResult br,Model model){
            //        if(br.hasErrors()){
            //            return "dataTemplate/edit";
            //        }
            //        DataTemplateBean scenarioBean = dataTemplateService.getDataTemplateById(id);
            //        scenarioBean.setName(dataTemplateDTO.getName());
            //        scenarioBean.setType(dataTemplateDTO.getType());
            //        scenarioBean.setDescription(dataTemplateDTO.getDescription());
            //        dataTemplateService.updateDataTemplate(scenarioBean);
            //        return "redirect:/dataTemplate/list";
            //    }
            //
    @RequestMapping("/field/{tid}/delete/{fid}")
    public String fieldDelete(@PathVariable Integer tid, @PathVariable Integer fid){
        dataTemplateService.deleteDataTemplateFieldId(fid);
        return "redirect:/dataTemplate/field/"+tid+"/list";
    }


    @RequestMapping(value="/field/{tid}/update/{fid}",method=RequestMethod.GET)
    public String fieldUpdate(@PathVariable Integer tid, @PathVariable Integer fid ,Model model){


        model.addAttribute("dataTemplateBean", dataTemplateService.getDataTemplateById(tid));
        model.addAttribute("dataTemplateFieldBean", dataTemplateService.getDataTemplateFieldBean(fid));
        model.addAttribute("dataTemplateFieldDTO", new DataTemplateFieldDTO());
        model.addAttribute("dataTemplateFieldTestType", EnumUtils.enumProp2NameMap(DataTemplateFieldTestType.class,"name"));


        return "dataTemplate/field_edit";
    }
    @RequestMapping(value="/field/{tid}/update/{fid}",method=RequestMethod.POST)
    public String fieldUpdate(@PathVariable Integer tid,   @PathVariable Integer fid, @Valid DataTemplateFieldDTO dataTemplateFieldDTO,BindingResult br,Model model){
        if(br.hasErrors()){

            model.addAttribute("dataTemplateBean", dataTemplateService.getDataTemplateById(tid));
            model.addAttribute("dataTemplateFieldBean", dataTemplateService.getDataTemplateFieldBean(fid));
            model.addAttribute("dataTemplateFieldTestType", EnumUtils.enumProp2NameMap(DataTemplateFieldTestType.class,"name"));
            return "dataTemplate/field_edit";
        }
        DataTemplateFieldBean scenarioBean = dataTemplateService.getDataTemplateFieldBean(fid);
        scenarioBean.setDataContent(dataTemplateFieldDTO.getDataContent());
        scenarioBean.setTestType(dataTemplateFieldDTO.getTestType());
        dataTemplateService.updateDataTemplateFieldBean(scenarioBean);
        return "redirect:/dataTemplate/field/"+tid+"/list";
    }
}
