<?php
namespace App\Model\Table;

use Cake\ORM\Query;
use Cake\ORM\RulesChecker;
use Cake\ORM\Table;
use Cake\Validation\Validator;

/**
 * Mediatype Model
 *
 * @method \App\Model\Entity\Mediatype get($primaryKey, $options = [])
 * @method \App\Model\Entity\Mediatype newEntity($data = null, array $options = [])
 * @method \App\Model\Entity\Mediatype[] newEntities(array $data, array $options = [])
 * @method \App\Model\Entity\Mediatype|bool save(\Cake\Datasource\EntityInterface $entity, $options = [])
 * @method \App\Model\Entity\Mediatype patchEntity(\Cake\Datasource\EntityInterface $entity, array $data, array $options = [])
 * @method \App\Model\Entity\Mediatype[] patchEntities($entities, array $data, array $options = [])
 * @method \App\Model\Entity\Mediatype findOrCreate($search, callable $callback = null, $options = [])
 */
class MediatypeTable extends Table
{

    /**
     * Initialize method
     *
     * @param array $config The configuration for the Table.
     * @return void
     */
    public function initialize(array $config)
    {
        parent::initialize($config);

        $this->setTable('mediatype');
        $this->setDisplayField('ID');
        $this->setPrimaryKey('ID');
    }

    /**
     * Default validation rules.
     *
     * @param \Cake\Validation\Validator $validator Validator instance.
     * @return \Cake\Validation\Validator
     */
    public function validationDefault(Validator $validator)
    {
        $validator
            ->integer('ID')
            ->allowEmpty('ID', 'create');

        $validator
            ->scalar('Type')
            ->maxLength('Type', 20)
            ->requirePresence('Type', 'create')
            ->notEmpty('Type');

        return $validator;
    }
}
