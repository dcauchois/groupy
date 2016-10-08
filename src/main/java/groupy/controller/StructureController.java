package groupy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import groupy.entity.Structure;
import groupy.service.StructureService;

@Controller
@RequestMapping("structure")
public class StructureController {
	
	@Autowired
	private StructureService structureService;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<Structure> getAll(){
		return structureService.retrieveAll();
	}

}
