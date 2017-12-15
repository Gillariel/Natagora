<?php
namespace App\Model\Table;

use Cake\ORM\Query;
use Cake\ORM\RulesChecker;
use Cake\ORM\Table;
use Cake\Validation\Validator;

/**
 * User Model
 *
 * @method \App\Model\Entity\User get($primaryKey, $options = [])
 * @method \App\Model\Entity\User newEntity($data = null, array $options = [])
 * @method \App\Model\Entity\User[] newEntities(array $data, array $options = [])
 * @method \App\Model\Entity\User|bool save(\Cake\Datasource\EntityInterface $entity, $options = [])
 * @method \App\Model\Entity\User patchEntity(\Cake\Datasource\EntityInterface $entity, array $data, array $options = [])
 * @method \App\Model\Entity\User[] patchEntities($entities, array $data, array $options = [])
 * @method \App\Model\Entity\User findOrCreate($search, callable $callback = null, $options = [])
 */
class UserTable extends Table
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

        $this->setTable('user');
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
            ->scalar('Pseudo')
            ->maxLength('Pseudo', 30)
            ->requirePresence('Pseudo', 'create')
            ->notEmpty('Pseudo');

        $validator
            ->scalar('Name')
            ->maxLength('Name', 50)
            ->requirePresence('Name', 'create')
            ->notEmpty('Name');

        $validator
            ->scalar('Forname')
            ->maxLength('Forname', 50)
            ->requirePresence('Forname', 'create')
            ->notEmpty('Forname');

        $validator
            ->scalar('Mail')
            ->maxLength('Mail', 60)
            ->requirePresence('Mail', 'create')
            ->notEmpty('Mail');

        $validator
            ->scalar('Password')
            ->maxLength('Password', 512)
            ->requirePresence('Password', 'create')
            ->notEmpty('Password');

        $validator
            ->dateTime('Join_Date')
            ->requirePresence('Join_Date', 'create')
            ->notEmpty('Join_Date');

        $validator
            ->scalar('Picture')
            ->maxLength('Picture', 1024)
            ->requirePresence('Picture', 'create')
            ->notEmpty('Picture');

        $validator
            ->integer('Role_ID')
            ->requirePresence('Role_ID', 'create')
            ->notEmpty('Role_ID');

        return $validator;
    }
}
