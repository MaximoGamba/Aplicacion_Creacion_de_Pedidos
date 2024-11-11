import React from 'react';
import { Link } from 'react-router-dom';

const Header = () => (
  <header>
    <h1>Gestión de Pedidos</h1>
    <nav>
      <ul>
        <li><Link to="/">Lista de Pedidos</Link></li>
        <li><Link to="/new-order">Crear Pedido</Link></li>
      </ul>
    </nav>
  </header>
);

export default Header;
