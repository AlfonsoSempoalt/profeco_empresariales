package com.api.rest;

import control.mercado.ControlMercado;
import control.consumidor.ControlConsumidor;
import control.profeco.ControlProfeco;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.ProductoDAO;
import dao.SancionDAO;
import entities.Producto;
import entities.Sancion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/profeco")
public class ProfecoREST {
	private ProductoDAO daoProducto;
        private SancionDAO daoSancion;
        
        public ProfecoREST(){
            this.daoProducto = new ProductoDAO();
            this.daoSancion = new SancionDAO();
        }


        
	@RequestMapping(value="consumidor/{nombreProducto}")
	public ResponseEntity<List<Producto>> compararProductos(@PathVariable("nombreProducto")String nombre){
		ControlConsumidor consumidor = new ControlConsumidor(this.daoProducto);
		return ResponseEntity.ok(consumidor.getProductByName(nombre));
	}
        
       
        @PostMapping()
	public ResponseEntity<Sancion> determinarSancion(@RequestBody String sancion){
            System.out.println("Entra posteo" + sancion);
            ControlProfeco profeco = new ControlProfeco(this.daoSancion);
            Sancion s = profeco.sancionar(sancion);
            return ResponseEntity.ok(s);
	}
        
        @RequestMapping(value="comercio")
	public ResponseEntity<List<Sancion>> showSanciones(){
            ControlMercado comercio = new ControlMercado(this.daoSancion);
            return ResponseEntity.ok(comercio.leerSanciones());
	}
        
        
        
}
