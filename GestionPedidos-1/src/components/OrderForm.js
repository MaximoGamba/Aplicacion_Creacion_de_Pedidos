import React, { useState } from 'react';
import { createOrder } from '../services/api';
import 'bootstrap/dist/css/bootstrap.min.css';

const OrderForm = () => {
  const [description, setDescription] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    await createOrder({ description });
    setDescription('');
  };

  return (
    <form onSubmit={handleSubmit} className="container mt-5">
      <div className="mb-3">
        <label htmlFor="description" className="form-label">Descripción del Pedido</label>
        <input
          type="text"
          className="form-control"
          id="description"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
          placeholder="Descripción del Pedido"
        />
      </div>
      <button type="submit" className="btn btn-primary">Crear Pedido</button>
    </form>
  );
};

export default OrderForm;
