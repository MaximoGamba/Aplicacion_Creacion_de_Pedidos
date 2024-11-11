import React, { useEffect, useState } from 'react';
import { getOrders } from '../services/api';
import 'bootstrap/dist/css/bootstrap.min.css';

const OrderList = () => {
  const [orders, setOrders] = useState([]);

  useEffect(() => {
    getOrders().then(data => setOrders(data));
  }, []);

  return (
    <div className="container mt-5">
      <h2>Lista de Pedidos</h2>
      <ul className="list-group">
        {orders.map(order => (
          <li key={order.id} className="list-group-item">{order.description}</li>
        ))}
      </ul>
    </div>
  );
};

export default OrderList;
